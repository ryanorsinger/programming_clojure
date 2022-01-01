
(defn hello
    "returns a greeting to the username or greets generically"
    ([] (hello "world"))
    ([username] (str "Hello, " username "!")))



(defn greet
    "Returns a greeting to the username or any arity of username strings"
    ([] (greet "world"))
    ([username] (str "Hello, " username "! \n")) ; I need the 'base case' implementation that other calling options call
    ([username & others]
        (clojure.string/join 
            (greet username)
            (map greet others))))
