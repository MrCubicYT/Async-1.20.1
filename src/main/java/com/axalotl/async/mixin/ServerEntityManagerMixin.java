package com.axalotl.async.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerEntityManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkSectionPos;
import net.minecraft.world.entity.EntityChangeListener;
import net.minecraft.world.entity.EntityLike;
import net.minecraft.world.entity.EntityTrackingSection;
import net.minecraft.world.entity.EntityTrackingStatus;
import org.spongepowered.asm.mixin.*;

@Mixin(ServerEntityManager.Listener.class)
public abstract class ServerEntityManagerMixin<T extends EntityLike> implements AutoCloseable {
    @Shadow
    private EntityTrackingSection<T> section;

    @Shadow
    @Final
    private T entity;

    @Shadow
    private long sectionPos;
    @Final
    @Shadow
    ServerEntityManager<T> manager;


    @Shadow protected abstract void updateLoadStatus(EntityTrackingStatus oldStatus, EntityTrackingStatus newStatus);

    /**
     * @author Axalotl
     * @reason RemoveWarns
     */
    @Overwrite
    public void remove(Entity.RemovalReason reason) {
        this.section.remove(this.entity);
        EntityTrackingStatus entityTrackingStatus = ServerEntityManager.getNeededLoadStatus(this.entity, this.section.getStatus());
        if (entityTrackingStatus.shouldTick()) {
            this.manager.stopTicking(this.entity);
        }
        if (entityTrackingStatus.shouldTrack()) {
            this.manager.stopTracking(this.entity);
        }
        if (reason.shouldDestroy()) {
            this.manager.handler.destroy(this.entity);
        }
        this.manager.entityUuids.remove(this.entity.getUuid());
        this.entity.setChangeListener(EntityChangeListener.NONE);
        this.manager.entityLeftSection(this.sectionPos, this.section);
    }

    /**
     * @author Axalotl
     * @reason RemoveWarns && Add nulls check
     */
    @Overwrite
    public void updateEntityPosition() {
        BlockPos blockPos = this.entity.getBlockPos();
        long l = ChunkSectionPos.toLong(blockPos);
        if (l != this.sectionPos) {
            EntityTrackingStatus entityTrackingStatus = this.section.getStatus();
            this.section.remove(this.entity);
            this.manager.entityLeftSection(this.sectionPos, this.section);
            EntityTrackingSection<T> entityTrackingSection = this.manager.cache.getTrackingSection(l);
            if (entityTrackingSection == null) return;
            entityTrackingSection.add(this.entity);
            this.section = entityTrackingSection;
            this.sectionPos = l;
            this.updateLoadStatus(entityTrackingStatus, entityTrackingSection.getStatus());
        }
    }
}