"""
The Viterbi algorithm is a dynamic programming algorithm for finding the most 
likely sequence of hidden states that results in a given sequence of observations. 
It is used in a wide variety of applications, including speech recognition,
natural language processing, and machine learning.
"""
def viterbi(observations, states, transition_probabilities, emission_probabilities):
  """Computes the most likely sequence of hidden states that results in a given sequence of observations.

  Args:
    observations: A list of observations.
    states: A list of hidden states.
    transition_probabilities: A numpy array representing the transition probabilities between hidden states.
    emission_probabilities: A numpy array representing the emission probabilities from hidden states.

  Returns:
    A list of hidden states representing the most likely sequence of hidden states.
  """

  trellis = np.zeros((len(observations), len(states)))
  backpointers = np.zeros((len(observations), len(states)), dtype=int)

  # Initialize the trellis.
  for i in range(len(states)):
    trellis[0, i] = emission_probabilities[i][observations[0]]

  # Compute the trellis.
  for t in range(1, len(observations)):
    for i in range(len(states)):
      for j in range(len(states)):
        prob = trellis[t - 1, j] * transition_probabilities[j][i] * emission_probabilities[i][observations[t]]
        if prob > trellis[t, i]:
          trellis[t, i] = prob
          backpointers[t, i] = j

  # Backtrack through the trellis to find the most likely sequence of hidden states.
  path = []
  state = np.argmax(trellis[-1, :])
  path.append(state)
  for t in range(len(observations) - 1, 0, -1):
    state = backpointers[t, state]
    path.append(state)

  path.reverse()
  return path

