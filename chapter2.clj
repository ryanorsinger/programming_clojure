; a zero or one argument arity
(defn hello
    "returns a greeting to the username or greets generically"
    ([] (hello "world"))
    ([username] (str "Hello, " username "!")))


; Arbitrary arity with & for optional extra arguments
(defn greet
    "Returns a greeting to the username or any arity of username strings"
    ([] (greet "world"))
    ([username] (str "Hello, " username "! \n")) ; I need the 'base case' implementation that other calling options call
    ([username & others]
        (clojure.string/join 
            (greet username)
            (map greet others))))

;; why use anonymous functions?
; - when the function is so brief and self-explanatory that giving it a name makes the code harder to read
; - the function is only being used from inside another function and needs a local name
; - the function is created inside another function to caputure parameters or local bindings (closing over with a closure)

; consider this example
(defn indexible-word? [word]
    (> (count word) 2))

(require '[clojure.string :as str])
(filter indexible-word? (str/split "What a fine day we're having here eh?" #"\W+"))

; consider replacing the above with the below (or not if it's not "easier" for your own measure of easy)
; this is the book's example, but I prefer the abstraction level of the named function, personally
; functions that do one thing and one thing only are definitionally simpler, by the objective measure of simple: count of steps
; I see where the authors are going with this, but this example rings like an example to use named functions, to me.
(filter (fn [w] (> (count w) 2)) (str/split ) "What a fine day we're having here eh?" #"\W+")


; shorter anonymous form than using "fn"
(filter #(> (count %) 2) (str/split  "What a fine day we're having here eh?" #"\W+"))

; or
(filter #(= % 2) [1 2 2 3 3 3 3 4 4 4 4])

; or another example

(defn indexible-words? [text]
    ; let indexible-word? be a function that returns if the number of characters is greater than 2
    (let [indexible-word? (fn [w] (> (count w) 2))]
        (filter indexible-word? (str/split text #"\W+"))))

(indexible-words? "What a fine day we're having here eh?")



; Here's the closing over to make a closure example/rationale

(defn make-greeter [greeting-prefix]
    (fn [username] (str greeting-prefix ", " username)))

; the two examples are closures over the meeting prefix
(def texan-greeting (make-greeter "Howdy"))
(println (texan-greeting "Governor Anne Richards"))

(def hawaiian-greeting (make-greeter "Aloha"))
(println (hawaiian-greeting "Bob"))

