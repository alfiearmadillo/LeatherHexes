# Leather Hexes

A small client-side Fabric mod that adds the dye colour hex code to leather armour tooltips.

## What it does

Hovering over any dyed leather armour piece displays the colour as a hex code directly below the item name:

```
Leather Chestplate
Color: #FCF3FF
```

The hex value is rendered in its own colour. If another mod (e.g. Skyblocker) is already showing the hex for a given item, this mod won't add a duplicate.

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/installer/)
2. Install [Fabric API](https://modrinth.com/mod/fabric-api)
3. Drop the mod JAR into your `.minecraft/mods/` folder

Client-side only — safe on any server.

## Building

```bash
./gradlew build
```

Requires Java 21.
