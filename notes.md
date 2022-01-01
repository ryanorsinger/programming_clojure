
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
- `(source a-symbol)` is the general form.
- `(source str)` pulls the source code for the `str` function
- `(source source)` returns the source for the `source` function

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

## Good to know
- No statements, only expressions expressed in generally arbitrary ways
- () make lists, runtime evaluates lists as function calls. First element is the operation.

## Operations
- `(/ 22 7)` returns a ratio tuype
- `(/ 22.0 7)` returns a float
- `(rem 22 7)` returns the remainder
- `(quot 22 7)` returns the quotient
- To make BigDecimal literals, add M to the number
- To make BigInt literals, add N to one of the numbers

## Symbols
- functions like `str` and `concat`
- "operators" like + are functions
- java classes like java.lang.String and java.util.Random
- Namespaces like clojure.core and Java packages like java.lang
- Symbols cannot start with numbers but can contain alphanumeric and some special characters

## Collections
- lists, vectors, sets, and maps
- all collections can be heterogeneous
- `(:lisp {:lisp "McCarthy" :clojure "Hickey"})` returns "McCarthy".
- keywords resolve to themselves.
- If we have several keys in common, we can create a record with defrecord

## Booleans and nil
- true is true
- false is false
- nil is false
- everything else evaluates to true
	- `(boolean 0)`, `(boolean "")`, `(boolean [])` each evaluate to `true`.
- Predicate functions always return true or false.
	- (true? expr)
	- (false? expr)
	- (nil? expr)
	- (zero? expr)
	- (empty? expr)
	- (string? expr)
	- (keyword? expr)
	- (symbol? expr)
- The only expression that returns true for true? is true.
- Only nil is `nil?`. Only false is `false?`.
- Many more predicates in clojure. To list, run `(find-doc #"\?$")`

## Functions
- Use defn to define functions
- Function names are typically hyphenated like `find-doc` and `load-file`
- Predicate function names should have a `?` at the end.
- General form is `(defn name docstring? attr-map? [params*] prepost-map? body)`
	- Docstrings are optional, so are attr-maps and prepost-maps
	- Attr-map is metadata
	- prepost-map? can define preconditions or postconditions checked on invocation.
- How to write a greeting function issue a generic greeting when the caller omits the argument
	```clojure
	(defn greeting
	"returns a greeting to the username or greets generically"
	([] (greeting "world"))
	([username] (str "Hello, " username "!")))
	```
- We can create functions with variable arity by including an ampersand in the parameter list. Clojure binds the name after the ampersand to a sequence of the remaining parameters. There may be only one variable arity parameter, and it must be last in the parameter list. 
	- (defn date [person-1 person-2 & chaperones]
		(println person-1 "and" person-2 "went out with " (count chaperones) "chaperones."))


## Reader Macro Forms
- `'`

## Errors
- An `ArityException` means incorrect number of arguments.

## Things to review and reinforce with practice
- working with namespaces and requires
- working w/ classpaths on namespaces

