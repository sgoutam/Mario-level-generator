
#! /usr/bin/env python3

arr = []


outfile = open("Clingo Levels/input.txt", "w")

with open("trial2.txt", "r") as f:
	for line in f:
		if line.startswith("at("):
			words = line.strip('\n').split(" ")
			for word in words:
				x = word.rstrip("at(").rstrip(")").split(",")[2]
				outfile.write(x)
				outfile.write('\n')

outfile.close()
