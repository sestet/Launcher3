# Launcher3

Android Studio/Gradle project for AOSP Launcher3.

[简体中文](README.zh-CN.md) | [日本語](README.ja.md)

## Source

- Launcher3: https://android.googlesource.com/platform/packages/apps/Launcher3
- Branch: `android16-qpr2-release`

## Build

Requirements:

- JDK 17+
- Android SDK platform 36

```bash
./gradlew :assembleDebug
```

Debug APK:

```text
build/outputs/apk/debug/Launcher3-debug.apk
```

## Install

```bash
adb install -r build/outputs/apk/debug/Launcher3-debug.apk
adb shell am start -W -n com.android.launcher3/.Launcher
```

## Modules

| Module | Path | Source | Role |
| --- | --- | --- | --- |
| `:` | `.` | AOSP `platform/packages/apps/Launcher3` | Launcher3 app module. The Gradle manifest is `launcher3/AndroidManifest.xml`; source and resources stay in the AOSP layout. |
| `:concurrent` | `modules/concurrent` | AOSP Launcher3 | Launcher executor qualifiers and concurrency bindings. |
| `:dagger` | `dagger` | AOSP Launcher3 | Dagger qualifier annotations used by Launcher3. |
| `:launcher-testing-shared` | `shared` | AOSP Launcher3 | Shared Launcher test/support APIs required by the build. |
| `:iconloaderlib` | `platform_frameworks_libs_systemui/iconloaderlib` | AOSP `platform/frameworks/libs/systemui/iconloaderlib` | Icon loading and icon cache library used by Launcher3. |
| `:animationlib` | `platform_frameworks_libs_systemui/animationlib` | Local compatibility layer | Minimal animation APIs used by Launcher3. |
| `:msdllib` | `platform_frameworks_libs_systemui/msdllib` | Local compatibility layer | Minimal MSDL APIs used by Launcher3. |
| `:plugincore` | `systemUI/plugin_core` | Local compatibility layer for AOSP SystemUI `plugin_core` | Minimal SystemUI plugin core interfaces. |
| `:systemui-statsd` | `systemUI/statsd` | Local compatibility layer | Minimal `SysUiStatsLog` constants used by Launcher3. |
| `:wmshell` | `wmshell` | Local compatibility layer for AOSP WM Shell | Minimal WM Shell APIs used by Launcher3. |
| `:flags` | `flags` | Local compatibility layer | Platform flag API stubs used outside the full Android platform build. |

## License

Apache License 2.0. See `LICENSE`.
