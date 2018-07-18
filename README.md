# Start

# Known problems

You might see:
Configuration on demand is not supported by the current version of the Android Gradle plugin since you are using Gradle version 4.6 or above. Suggestion: disable configuration on demand by setting org.gradle.configureondemand=false in your gradle.properties file or use a Gradle version less than 4.6.

Also:
Error:The modules ['android', 'mobile'] point to the same directory in the file system.
Each module must have a unique path.

# Hacks

Multiplatform development in Kotlin still have some limitations.
This is why I had to apply some hacks which are temporary.

## Native dependencies

