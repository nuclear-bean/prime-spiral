# prime-spiral

### Overview

This is a tool for visualizing and exploring prime spirals. Ulam Spiral is currently the only supported variation.

Read more about Ulam Spiral here: https://en.wikipedia.org/wiki/Ulam_spiral

### Usage

explore spiral/src/main/java/spirals/ulam/examples for examples of how to generate spirals.

### Examples

- **E01_BasicBlackAndWhite** - simply generates a spiral and exports it to a png file. Primes are black, non-primes are
  white.
- **E02_ExportToCSV** - generates a spiral and exports it to a csv file. Primes are 1, non-primes are 0.
- **E03_ExportToSlimCSV** - generates a spiral and exports it to a csv file. Primes are 1, non-primes are 0. The csv
  file does not contain commas to save size.
- **E04_DensityRepresentation** - creates basic density representation image. Density is calculated by counting the
  number of neighbour primes (and self) for each number. The density is then mapped to a color. The higher the density,
  the brighter the color.
- **E05_CustomizableDensityRepresentation** - same as E04, but allows for customizing the density calculation and color
  mapping.
- **E06_DensityWithRadiusAndBias** - create density representation with custom radius and bias. Radius is the number of
  neighbours to consider when calculating density. Bias is the amount of density to add to a specific point if it's a
  prime. This is useful for highlighting primes.