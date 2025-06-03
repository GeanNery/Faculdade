print("DIGITE A HORA NO FORMATO [HH:MM:SS]")
horaInput = input()
horaSplit = horaInput.split(":")

if len(horaSplit) > 3 or int(horaSplit[0]) > 23 or int(horaSplit[1]) > 59 or int(horaSplit[2]) > 59:
  print("\nEntrada inválida! Tente novamente.")
else:
  horaSeg = 60 * 60 * int(horaSplit[0])
  minSeg = 60 * int(horaSplit[1])
  Seg = int(horaSplit[2])
  print(f"\nO período informado corresponde a {horaSeg + minSeg + Seg} segundos.")