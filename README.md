# ZipBench

A quick benchmark comparing loading a zip or walking the filesystem.

### Usage

Unzip the `node_modules.zip` file into the root folder so the structure is `<PROJECT_FOLDER>/node_modules`. Then run the `BenchMain` file to compare.

### Results

#### Windows

(these results are very preliminary and should not be considered authoritative)

```
Result "bench.BenchMain.countZip":
  0,824 ±(99.9%) 0,079 ops/s [Average]
  (min, avg, max) = (0,673, 0,824, 1,031), stdev = 0,106
  CI (99.9%): [0,745, 0,903] (assumes normal distribution)

Result "bench.BenchMain.countDir":
  0,460 ±(99.9%) 0,007 ops/s [Average]
  (min, avg, max) = (0,435, 0,460, 0,474), stdev = 0,010
  CI (99.9%): [0,453, 0,467] (assumes normal distribution)
```