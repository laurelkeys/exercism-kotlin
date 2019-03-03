import os
from shutil import copy
from sys import argv

def copy_from(src_path, dst_path):
    for file in os.listdir(src_path):
        if (file.endswith(".kt")):
            try:
                copy(src_path + file, dst_path + file)
            except IOError as io_err:
                os.makedirs(os.path.dirname(dst_path))
                copy(src_path + file, dst_path + file)

src = os.getcwd() # add this file to your Exercism's 'kotlin' folder
dst = os.getcwd() + "\\..\\github\\exercism-kotlin\\"

if len(argv) > 1:
    dst = argv[1]
    if len(argv) > 2:
        src = argv[2]

print("src: " + src + "\ndst: " + dst + "\n")

for folder in os.listdir(src):
    if (os.path.isdir(folder)):
        copy_from(src + "\\" + folder + "\\src\\main\\kotlin\\", dst + folder + "\\") # exercise
        copy_from(src + "\\" + folder + "\\src\\test\\kotlin\\", dst + folder + "\\") # unit tests
