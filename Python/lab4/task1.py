import numpy as np

class HopfieldNetwork:
    def __init__(self, size):
        self.size = size
        self.weights = np.zeros((size, size))

    def train(self, patterns):
        patterns = [np.where(p == 0, -1, 1) for p in patterns]
        for p in patterns:
            self.weights += np.outer(p, p)
        np.fill_diagonal(self.weights, 0)

    def predict(self, data, max_iter=10):
        state = np.where(data == 0, -1, 1)
        for _ in range(max_iter):
            previous_state = state.copy()
            for i in range(self.size):
                net_input = np.dot(self.weights[i], state)
                state[i] = 1 if net_input > 0 else -1
            if np.array_equal(state, previous_state):
                break
        return np.where(state == -1, 0, 1)

patterns = [
    np.array([0, 0, 0, 0, 1, 1, 1, 1]),   
    np.array([1, 1, 1, 1, 0, 0, 0, 0]),   
    np.array([1, 0, 1, 0, 1, 0, 1, 0])    
]

network = HopfieldNetwork(size=8)
network.train(patterns)

test_pattern = np.array([1, 1, 0, 0, 1, 1, 0, 0])
output = network.predict(test_pattern)

print("Input vector:", test_pattern)
print("Output vector:", output)
