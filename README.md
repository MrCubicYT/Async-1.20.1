[![Issues](https://img.shields.io/github/issues/AxalotLDev/Async?style=for-the-badge)](https://github.com/AxalotLDev/Async/issues)
<img width="200" src="https://github.com/AxalotLDev/Async/raw/ver/1.21.1/src/main/resources/assets/async/icon.png" alt="Async icon" align="right">
<div align="left">
<h1>Async - Minecraft Entity Multi-Threading Mod</h1>
<h3>Async is a Fabric mod designed to improve the performance of entity processing by processing them in parallel.</h3>
</div>

## So what is Async?
Async is a Fabric mod designed to improve entity processing performance. It does this by taking advantage of multiple CPU cores in parallel. It is recommended to use with Lithium for best performance.

## So what is Async not?
Async is currently in alpha stage and pretty experimental.
Although it is usable in most cases and tested during build time, it doesn't mean that it is fully stable for a production server.
So backup your worlds and practice good game modding skills.

## Download
Modrinth: https://modrinth.com/mod/async

## Support status for Minecraft versions
Only the latest Minecraft release and are fully supported. Older Minecraft releases are in long-term support and will receive critical bug fixes. Older Minecraft snapshots are not supported.

## Support C2ME?
The mod supports C2ME if you disable 2 mixins in it: asynccatchers.MixinThreadedAnvilChunkStorage and threading_detections.random_instances.MixinWorld

## Support
Our issue tracker: [link](https://github.com/AxalotLDev/Async/issues)

## Configuration
Async offers numerous settings for fine-tuning its behavior. Use the `/async config` command in-game to access the configuration menu.

## Note to Users
While Async significantly improves performance, results may vary depending on your hardware and the specifics of your game world. We recommend experimenting with the settings to achieve the optimal balance of performance and stability.

## Acknowledgements
This mod is based on the ideas from [JMT-MCMT](https://github.com/jediminer543/JMT-MCMT). Many thanks to the original developers for their pioneering work in Minecraft optimization.

## License
License information can be found [here](/LICENSE).
