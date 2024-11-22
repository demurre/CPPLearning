import numpy as np

learning_rate = 0.1
epochs = 100
num_neurons = 5
input_vectors = [
    [1, 2, 3, 4, 5, 6, 7, 8, 9],
    [9, 8, 7, 6, 5, 4, 3, 2, 1],
    [1, 2, 1, 2, 2, 1, 2, 2, 1],
    [4, 4, 4, 4, 2, 2, 2, 2, 1],
    [1, 2, 3, 1, 2, 3, 1, 2, 3],
]

weights = np.random.rand(num_neurons, len(input_vectors[0]))


def kohonen_train(input_vectors, weights, learning_rate, epochs):
    for epoch in range(epochs):
        for vector in input_vectors:
            vector = vector / np.linalg.norm(vector)
            activations = np.dot(weights, vector)
            winner_index = np.argmax(activations)
            weights[winner_index] += learning_rate * (vector - weights[winner_index])
            weights[winner_index] = weights[winner_index] / np.linalg.norm(
                weights[winner_index]
            )

    return weights


weights = kohonen_train(input_vectors, weights, learning_rate, epochs)


def kohonen_predict(vector, weights):
    vector = vector / np.linalg.norm(vector)
    activations = np.dot(weights, vector)
    return np.argmax(activations)


test_vector = [1, 3, 3, 4, 5, 6, 7, 8, 9]
predicted_class = kohonen_predict(test_vector, weights)
print(f"Class of the test vector: {predicted_class}")
