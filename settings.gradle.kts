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

rootProject.name = "My Catalog"
include(":app")
include(":features:dashboard")
include(":features:account")
include(":features:cart")
include(":features:post")
include(":features:alerts")
