# prime-spiral

### Overview

This is a tool for visualizing and exploring prime spirals. Ulam Spiral is currently the only supported variation.

Read more about Ulam Spiral here: https://en.wikipedia.org/wiki/Ulam_spiral

### Usage

explore `spiral/src/main/java/spirals/ulam/examples` for examples on how to generate spirals.

### Examples

- **E01_BasicBlackAndWhite** - simply generates a spiral and exports it to a png file. Primes are mapped to black pixels, non-primes are
  white.
- **E02_ExportToCSV** - generates a spiral and exports it to a csv file. Primes are 1, non-primes are 0.
- **E03_ExportToSlimCSV** - generates a spiral and exports it to a csv file. Primes are 1, non-primes are 0. The csv
  file does not contain commas to save size.
- **E04_TwinPrimesBlackAndWhite** - same as E01 but only twin primes are marked on the output image.
- ~~**E05_CustomizableDensityRepresentation**~~ - **_DEPRECATED_**
- **E06_DensityWithRadiusAndBias** - density representation with custom radius and bias. Radius is the number of
  neighbours to consider when calculating density. Bias is the amount of density to add to a specific point if it's a
  prime (useful for highlighting primes).
- **E07_DiagonalConnectionsWithinRadius** - density representation that only considers diagonal neighbours within a specified 
  radius. Prime bias is supported.
- **E08_HighlightTwinPrimes** - Similar to E01 but twin primes are highlighted in red.


#### todo notes
- matrix compression (ability to store huge matrices in a small file)
- matrix caching - to speed up the generation process - pre-generated matrix to be read from file