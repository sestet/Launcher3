pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Launcher3"

fun includeModule(name: String, path: String = name) {
    include(":$name")
    project(":$name").projectDir = file(path)
}

includeModule("animationlib", "platform_frameworks_libs_systemui/animationlib")
includeModule("iconloaderlib", "platform_frameworks_libs_systemui/iconloaderlib")
includeModule("msdllib", "platform_frameworks_libs_systemui/msdllib")
includeModule("plugincore", "systemUI/plugin_core")
includeModule("systemui-statsd", "systemUI/statsd")
includeModule("concurrent", "modules/concurrent")
includeModule("launcher-testing-shared", "shared")
includeModule("dagger")
includeModule("flags")
includeModule("wmshell")
