plugins {
    kotlin("jvm")
}

dependencies {
    api(libs.kotlinx.coroutines.core)
    api(projects.client)
}
