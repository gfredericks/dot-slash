# dot-slash

A Leiningen plugin that constructs a custom repl utils namespace,
named `.` by default.

The idea is that if your utilities are in a shortly-named namespace,
instead of refer'd in just the `user` namespace, they can be easily
accessed the same way no matter how you are evaluating code.

## Usage

In your `:user` profile (or whatever):

``` clojure
  :plugins [[com.gfredericks/dot-slash "0.1.0-SNAPSHOT"]
            ...]
  :dot-slash {:vars [clojure.pprint/pprint
                     ...]}
```

And then in `lein repl`:

``` clojure
user=> (./pprint (apply array-map (range 40)))
{0 1,
 2 3,
 4 5,
 6 7,
 8 9,
 10 11,
 12 13,
 14 15,
 16 17,
 18 19,
 20 21,
 22 23,
 24 25,
 26 27,
 28 29,
 30 31,
 32 33,
 34 35,
 36 37,
 38 39}
nil
```

## License

Copyright © 2014 Gary Fredericks

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
