from Utils import Util
from Utils import Triplet
from Utils import Parser
lex_units = []
if __name__ == '__main__':
	Util.parse_anaylzer_input(lex_units)
	actions = {}
	actions[("0", "<S>")] = "3"
	actions[("0", "<A>")] = "1"
	actions[("0", "<B>")] = "5"
	actions[("0", "b")] = "p2"
	actions[("0", "a")] = "p4"
	actions[("1", "a")] = "p8"
	actions[("1", "<A>")] = "7"
	actions[("2", "a")] = "r6"
	actions[("2", "b")] = "r6"
	actions[("2", "")] = "r6"
	actions[("3", "")] = "Prihvati()"
	actions[("4", "a")] = "r5"
	actions[("5", "b")] = "p2"
	actions[("5", "<S>")] = "6"
	actions[("5", "a")] = "p4"
	actions[("5", "")] = "r4"
	actions[("5", "<B>")] = "5"
	actions[("5", "<A>")] = "1"
	actions[("6", "")] = "r2"
	actions[("7", "<S>")] = "9"
	actions[("7", "b")] = "p2"
	actions[("7", "")] = "r3"
	actions[("7", "a")] = "p4"
	actions[("7", "<B>")] = "5"
	actions[("7", "<A>")] = "1"
	actions[("8", "a")] = "r5"
	actions[("8", "b")] = "r5"
	actions[("8", "")] = "r5"
	actions[("9", "")] = "r1"
	grammar = {}
	grammar["1"] = ('<S>', ['<A>', '<A>', '<S>', ''])
	grammar["2"] = ('<S>', ['<B>', '<S>', ''])
	grammar["3"] = ('<S>', ['<A>', '<A>', ''])
	grammar["4"] = ('<S>', ['<B>', ''])
	grammar["5"] = ('<A>', ['a', ''])
	grammar["6"] = ('<B>', ['b', ''])
	grammar["0"] = ("<S'>", ['<S>', ''])
	syn = []
	syn.append("a")
	parser = Parser(lex_units, syn, actions, grammar)
	parser.simulate()
