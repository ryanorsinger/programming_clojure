; Pure function
; (defn hello [name]
; 	(str "Hello, " name "!"))


; Defining an atom for shared state
; Rich Hickey says "an atom with some hashmaps on it is the 95% solution"
(def visitors (atom #{}))

; swap touches the atom
; conj conjoins the new stuff onto the atom
; (swap! visitors conj "Stu")
; (swap! visitors conj "Alex")
; (swap! visitors conj "Jane")

; (println visitors) prints the entire atom object
;(println @visitors)

; Put it all together
(defn hello 
	"Writes a hello message to *out*. Adds the username to the visitors list in memory and says hello!"
	[username]
	(swap! visitors conj username)
	(str "Hello, " username "!"))

; this binds the symbol "source" to call clojure.repl/source more directly
(require '[clojure.repl :refer [source]])
