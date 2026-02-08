# MCValac Extension Template

A starter template for creating extensions for the [MCBackpack](https://github.com/MCEngine/mcbackpack) plugin. This repository provides the boilerplate code, Gradle configuration, and lifecycle management required to build add-ons using the [MCExtension API](https://github.com/MCEngine/mcextension).

## 📋 Prerequisites

* **Java Development Kit (JDK):** 21 or higher (Compatible with Paper 1.21+).
* **Gradle:** (Wrapper is usually included).
* **GitHub Personal Access Token (PAT):** Required to download dependencies from the MCEngine repository.

## 🚀 Getting Started

To use this template for your own extension, follow these steps to rename and configure the project.

### 1. Project Identity
Open `gradle.properties` and update the project identity to match your new extension:

```properties
git-org-name=YourOrg
git-org-repository=your-repo-name

project-group=io.github.yourname
# Update the versioning as needed
project-version=1.0.0
```
### 2. Extension Configuration

Open `src/main/resources/extension.yml`. The `version` and `main` fields are automatically populated by Gradle, but you should update the extension name:

```yml
# The unique identifier for this extension
name: YourExtensionName

# The version of this extension
version: ${project_version}

# The full package path to your main class
main: ${project_group}.YourExtensionGroup

# Optional: Ensure MCBackpack is loaded first
base:
  depend: [MCBackpack]
```

### 3. Rename Packages and Classes

1. Rename the package directory: `src/main/java/io/github/mcvalac/template` -> `src/main/java/io/github/yourname/yourextension`.
2. Rename the main class `Template.java` to your desired class name.
3. Update the `package-info.java` Javadocs to reflect your new extension.

## 🛠 Building the Project

This project uses Gradle for dependency management and building.

### Dependency Authentication

Because this project depends on `mcextension` and `mcbackpack-common` hosted on GitHub Packages, you must authenticate.

Set the following environment variables on your machine or CI/CD pipeline:

|Variable|Description|
|---|---|
|`USER_GITHUB_NAME`|Your GitHub username.|
|`USER_GITHUB_TOKEN`|A Personal Access Token (PAT) with `read:packages` scope.|

### Build Commands

Standard Build:

```bash
./gradlew build
```

The output jar will be located in `build/libs/`.

**Local Development (Auto-Deploy):** If you want the jar to be automatically copied to a test server's plugin folder after building, set the MCEXTENSION_MCBACKPACK_BUILD_PATH environment variable.

* Linux/Mac: `export MCEXTENSION_MCBACKPACK_BUILD_PATH="/path/to/server/plugins/extensions"`
* Windows: `set MCEXTENSION_MCBACKPACK_BUILD_PATH="C:\path\to\server\plugins\extensions"`

When this variable is set, running `./gradlew jar` will compile the plugin and replace the old version in that folder automatically.

## 📦 Versioning Strategy

The `build.gradle` file implements dynamic versioning based on environment variables.

|Variable|Effect|Result Example|
|---|---|---|
|(None)|Local Snapshot|`2026.0.3-1-SNAPSHOT`|
|`DEV_RELEASE_VERSION=true`|Dev Release|`2026.0.3-1`|
|`BUILD_NUMBER=50`|CI Build|`2026.0.3-1-50-DEV`|
|`RELEASE_VERSION=v2026.0.3`|Official Release|`2026.0.3`|

## 📂 Project Structure

```Plaintext
root
├── build.gradle          # Main build logic & dependency auth
├── gradle.properties     # Project constants (Group, Version)
├── settings.gradle       # Project name
└── src
    └── main
        ├── java
        │   └── io/github/mcvalac/template
        │       ├── Template.java       # Main entry point (onLoad/onDisable)
        │       └── package-info.java   # Package documentation
        └── resources
            └── extension.yml           # Extension metadata (processed by Gradle)
```

## 🔗 References

* MCBackpack Repo: https://github.com/MCEngine/mcbackpack
* MCExtension Libs: https://github.com/MCEngine/mcextension

<hr>

*Maintained by MCValac*
