# Ciphers

Simple cipher project I wrote in 2017. WILL NOT BE UPDATED

Ciphers:

Code1:
Converts each character into two characters(whose sum is the original character), and shifts both characters by a value from the key. Character values are normal for Java, except the characters before space do not count(this is equivilant to subtracting two from each character value).
Example:

	input = 'ps' key = ' ! ! ! !'
	p -> n" (n = 78, " = 2 | n + " = 80 | 80 + 32 = 112 | 112 = p ASCII)
	n -> n + ' ' -> n
	" -> " + ' ' -> "
	p -> n"

	s -> n% (n = 78, % = 5 | n + % = 83 | 80 + 32 = 115 | 115 = s ASCII)
	n -> n + ! -> o
	% -> % + ! -> &
	p -> o%

	ps -> n"o%

