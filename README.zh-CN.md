# Launcher3

基于 AOSP Launcher3 的 Android Studio/Gradle 工程。

## 来源

- Launcher3: https://android.googlesource.com/platform/packages/apps/Launcher3
- 分支: `android16-qpr2-release`

## 构建

要求：

- JDK 17+
- Android SDK platform 36

```bash
./gradlew :assembleDebug
```

Debug APK：

```text
build/outputs/apk/debug/Launcher3-debug.apk
```

## 安装

```bash
adb install -r build/outputs/apk/debug/Launcher3-debug.apk
adb shell am start -W -n com.android.launcher3/.Launcher
```

## 模块

| 模块 | 路径 | 来源 | 作用 |
| --- | --- | --- | --- |
| `:` | `.` | AOSP `platform/packages/apps/Launcher3` | Launcher3 应用模块。Gradle 使用 `launcher3/AndroidManifest.xml` 作为清单，源码和资源保持 AOSP 目录结构。 |
| `:concurrent` | `modules/concurrent` | AOSP Launcher3 | Launcher executor qualifier 和并发绑定。 |
| `:dagger` | `dagger` | AOSP Launcher3 | Launcher3 使用的 Dagger qualifier 注解。 |
| `:launcher-testing-shared` | `shared` | AOSP Launcher3 | 构建需要的 Launcher 测试/共享支撑 API。 |
| `:iconloaderlib` | `platform_frameworks_libs_systemui/iconloaderlib` | AOSP `platform/frameworks/libs/systemui/iconloaderlib` | Launcher3 使用的图标加载和图标缓存库。 |
| `:animationlib` | `platform_frameworks_libs_systemui/animationlib` | 本项目兼容层 | Launcher3 用到的最小 animation API。 |
| `:msdllib` | `platform_frameworks_libs_systemui/msdllib` | 本项目兼容层 | Launcher3 用到的最小 MSDL API。 |
| `:plugincore` | `systemUI/plugin_core` | 对齐 AOSP SystemUI `plugin_core` 的本项目兼容层 | 最小 SystemUI plugin core 接口。 |
| `:systemui-statsd` | `systemUI/statsd` | 本项目兼容层 | Launcher3 用到的最小 `SysUiStatsLog` 常量。 |
| `:wmshell` | `wmshell` | 对齐 AOSP WM Shell 的本项目兼容层 | Launcher3 用到的最小 WM Shell API。 |
| `:flags` | `flags` | 本项目兼容层 | 脱离完整 Android 平台构建后使用的平台 flag API stub。 |

## 许可证

Apache License 2.0，见 `LICENSE`。
