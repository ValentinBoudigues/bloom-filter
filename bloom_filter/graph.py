import matplotlib.pyplot as plt
import pandas as pd
import numpy as np

df = pd.read_csv('result.csv')

data = pd.DataFrame(df, columns=['Type', 'Length', 'Time'])

for _ in range(2):
    plt.figure()
    
    for i in data['Type'].unique():
        x = data[data['Type'] == i]['Length']
        y = data[data['Type'] == i]['Time']
        
        a, b = np.polyfit(x, y, 1)
        
        x_r2 = list(range(0, 10000000))
        y_r2 = [a*i+b for i in x_r2]
        
        if _ == 0:
            plt.plot(x, y, label=i)
        if _ == 1:
            plt.plot(x_r2, y_r2, label=i)
        
        plt.legend(loc='upper left')
        
        plt.title("Different implementations of the Bloom Filter")

        plt.xlabel("Length of the filter")
        plt.ylabel("Time (ms)")

    plt.show()


"""
    import numpy as np
import matplotlib.pyplot as plt
import scipy.stats as stats

k = list(mesures.keys())
v = list(mesures.values())

a, b = np.polyfit(k, v, 1)

x = list(range(0, 21))
y = [a*i+b for i in x]



plt.figure()
plt.plot(k, v, label="Etalonnage")
plt.plot(x, y, label="R²")
plt.title("Etalonage capteur déformation")
plt.suptitle("Sans amplification")
plt.legend()

print(f"Sensibilite sans ampli : {a}")
e = [abs(i-j) for i, j in zip(v, y)]
print(f"e = {e}")
E = [(i/abs(min(v)))*100 for i in e]
print(f"Pire % = {max(E)}")

plt.figure()
print()

k = list(mesures.keys())
v = list(mesures.values())

a, b = np.polyfit(k, v, 1)
print(f"Sensibilite avec ampli : {a}")

x = list(range(0, 21))
y = [a*i+b for i in x]

e = [abs(i-j) for i, j in zip(v, y)]
print(f"e = {e}")
E = [(i/abs(min(v)))*100 for i in e]
print(f"Pire % = {max(E)}")

plt.plot(k, v, label="Etalonnage")
plt.plot(x, y, label="R²")
plt.legend()
plt.title("Etalonage capteur déformation")
plt.suptitle("Avec amplification")
plt.show()
"""