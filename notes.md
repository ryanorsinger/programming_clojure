
## Special Expressions
`*e` holds the entire last exception
`*1`, `*2`, and `*3` hold the ultimate, penultimate, and antepenultimate (last 3) return valeus
`(load-file "temp.clj")` loads a file into memory in the 

`(deref visitors) where `visitors` is the atom outputs the atom's contents
`@visitors` where `visitors` is the atom outputs the atom's contents

## Accessing Documentation and searching Docstrings
`(doc str)` or `(doc doc)` pulls up the docstring
`(find-doc "reduce")` will search the docs for any output matching the regex expression or string passed here
`(find-doc "map")`, for example returns anything mentioning "map"

## Returning source
- Much of clojure is written in Clojure and it's instructive to read the source code.
- `(clojure.repl/source a-symbol)` is the general form.
- `(clojure.rpl/source str)` pulls the source code for the `str` function

```clojure
; this binds the symbol "source" to call clojure.repl/source more directly
(require '[clojure.repl :refer [source]])
```

## Types and instances
`(type "foo")`
`(instance? java.util.Collection #{1 2})`

## Conventions for parameter names (the "good" names are usually taken by the function)
| Parameter | Usage         |
| --------- | ------------- |
| a         | A Java array  |
| expr      | An expression |
| r         | A ref         |
| agt       | An agent      |
| f         | A function    |
| v         | A vector      |
| coll      | A collection  |
| idx       | An index      |
| val       | A value       |


