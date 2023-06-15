# prime-spiral

### Overview

This is a tool for visualizing and exploring prime spirals. Ulam Spiral is currently the only supported variation.

Read more about Ulam Spiral here: https://en.wikipedia.org/wiki/Ulam_spiral

### Usage

explore `spiral/src/main/java/spirals/ulam/examples` for examples on how to generate spirals.

### Examples

Example classes can be found under `./spiral/src/main/java/spirals/ulam/examples`. Currently, divided into 2 categories: _basic_ and _density_. Basic examples 
simply calculate an Ulam's spiral and highlight or filter for a specific type of primes. Density examples calculate density of primes using different strategies. 
Each example class can be customized, just modify the static variables above _main_ method and run the method itself. Output will be saved 
to an appropriate directory in `./output`

#### List of example classes with description:

##### Basic
- **EB01_BasicUlam** - generates simple Ulam's spiral of given size. Primes are black pixels, composites are white
- **EB02_TwinPrimes** - marks only [twin primes](https://en.wikipedia.org/wiki/Twin_prime) or highlights them in red amongst all primes
- **EB03_SexyPrimes** - marks only [sexy primes](https://en.wikipedia.org/wiki/Sexy_prime)

##### Density
- **ED01_RadiusBias** - generates matrix of given size. Then each point is assigned a value equal to number of primes in a given radius. The brighter the pixel, 
the more primes are located around it. Actual primes can be applied a _bias_ value - which is useful for highlighting them. 
- **ED02_DiagonalConnectionsWithinRadiusWithCutoff** - similar to ED01 but only primes that are placed diagonally to given point are taken into consideration.
Cutoff value can be set - points with density value below this threshold will not be marked (corresponding pixels will be same as background value)

#### todo notes
- matrix compression (ability to store huge matrices in a small file)
- matrix caching - to speed up the generation process - pre-generated matrix to be read from file