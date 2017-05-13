# Swarm Fractions
A collection of custom [Wildfly Swarm Fractions](https://wildfly-swarm.gitbooks.io/wildfly-swarm-users-guide/fraction_authoring.html). 

[![Build Status](https://travis-ci.org/sventorben/swarm-fractions.svg?branch=master)](https://travis-ci.org/sventorben/swarm-fractions)

[![Code Coverage](https://img.shields.io/codecov/c/github/sventorben/swarm-fractions/master.svg)](https://codecov.io/github/sventorben/swarm-fractions?branch=master)

## Maven Coordinates

The latest RELEASE is available via Maven Central.

```
    <dependency>
        <groupId>de.sven-torben.wildfly.swarm.fractions</groupId>
        <artifactId>name of fraction</artifactId>
        <version>0.0.1</version>
    </dependency>
```

For latest SNAPHOT artifacts you need to integrate the Sonatype Maven repository like this: 

```
    <repository>
        <id>sonatype-nexus-snapshots</id>
        <name>Sonatype Nexus Snapshots</name>
        <url>https://oss.sonatype.org/content/repositories/snapshots</url>
        <releases>
            <enabled>false</enabled>
        </releases>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository
```
