# Launcher3

AOSP Launcher3 をベースにした Android Studio/Gradle プロジェクトです。

## ソース

- Launcher3: https://android.googlesource.com/platform/packages/apps/Launcher3
- ブランチ: `android16-qpr2-release`

## ビルド

必要な環境:

- JDK 17+
- Android SDK platform 36

```bash
./gradlew :assembleDebug
```

Debug APK:

```text
build/outputs/apk/debug/Launcher3-debug.apk
```

## インストール

```bash
adb install -r build/outputs/apk/debug/Launcher3-debug.apk
adb shell am start -W -n com.android.launcher3/.Launcher
```

## モジュール

| モジュール | パス | ソース | 役割 |
| --- | --- | --- | --- |
| `:` | `.` | AOSP `platform/packages/apps/Launcher3` | Launcher3 アプリモジュール。Gradle manifest は `launcher3/AndroidManifest.xml` を使用し、ソースとリソースは AOSP の構成を保ちます。 |
| `:concurrent` | `modules/concurrent` | AOSP Launcher3 | Launcher executor qualifier と並行処理の binding。 |
| `:dagger` | `dagger` | AOSP Launcher3 | Launcher3 で使う Dagger qualifier annotation。 |
| `:launcher-testing-shared` | `shared` | AOSP Launcher3 | ビルドに必要な Launcher のテスト/共有サポート API。 |
| `:iconloaderlib` | `platform_frameworks_libs_systemui/iconloaderlib` | AOSP `platform/frameworks/libs/systemui/iconloaderlib` | Launcher3 で使うアイコン読み込み/キャッシュライブラリ。 |
| `:animationlib` | `platform_frameworks_libs_systemui/animationlib` | ローカル互換レイヤー | Launcher3 で使う最小限の animation API。 |
| `:msdllib` | `platform_frameworks_libs_systemui/msdllib` | ローカル互換レイヤー | Launcher3 で使う最小限の MSDL API。 |
| `:plugincore` | `systemUI/plugin_core` | AOSP SystemUI `plugin_core` 向けローカル互換レイヤー | 最小限の SystemUI plugin core interface。 |
| `:systemui-statsd` | `systemUI/statsd` | ローカル互換レイヤー | Launcher3 で使う最小限の `SysUiStatsLog` 定数。 |
| `:wmshell` | `wmshell` | AOSP WM Shell 向けローカル互換レイヤー | Launcher3 で使う最小限の WM Shell API。 |
| `:flags` | `flags` | ローカル互換レイヤー | フル Android platform build 外で使う platform flag API stub。 |

## ライセンス

Apache License 2.0。詳細は `LICENSE` を参照してください。
