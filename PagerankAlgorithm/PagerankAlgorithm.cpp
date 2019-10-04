#include <iomanip>
#include <fstream>
#include <sstream>
#include <string>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

// Used to store edges from input file
struct edgePair {
	string first = ""; // Origin site
	string second = ""; // Destination site

	// Debug methods
	void printPair() {
		cout << "(" + first + ", " + second + ")" << endl;
	}
};

// Prototypes
void read(vector<edgePair>& edgeList, vector<string>& nodes, int& n, string fileName);
void matrixMult(vector<vector<double>>& A, vector<double>& x);
double dotProduct(vector<double>& x, vector<double>& y);

int main(int argc, char **argv) {

	// Validate cmd-line inputs
	if (argc > 2) {
		cout << "Error: Invalid number of inputs" << endl;
		return 1;
	}

	vector<edgePair> edges; // Store inputs as pairs (source, destination)
	vector<string> nodes; // Filters out duplicates of nodes
	int numPowIterations = 0;
	read(edges, nodes, numPowIterations, argv[1]); // Filename is 2nd argument (index 1)

	// Validate number of power iterations
	if (numPowIterations < 1) {
		cout << "ERROR: Power iteration must be at least 1" << endl;
		return 2;
	}

	int n = nodes.size(); // Avoids multiple calls to accessor

	// Construct adjacency matrix
	vector<vector<double>> adjMatrix;
	vector<double> rowTemplate;
	rowTemplate.assign(n, 0.0);
	adjMatrix.assign(n, rowTemplate); // Pass by value, copies premade row vector

	// Calculate outdegree for each node
	for (int i = 0; i < n; i++) {
		
		int outdegree = 0;
		
		vector<int> destinationIndexes;
		for (unsigned int edgeIter = 0; edgeIter < edges.size(); edgeIter++) {
			if (edges[edgeIter].first == nodes[i]) {
				
				outdegree++;

				// Get index of matching destination
				auto it = find(nodes.begin(), nodes.end(), edges[edgeIter].second); // Returns an iterator
				destinationIndexes.push_back(distance(nodes.begin(), it)); // Convert iterator into usable numerical index
			}
		}

		for (auto it = destinationIndexes.begin(); it != destinationIndexes.end(); it++) {
			adjMatrix[*it][i] = 1.0 / outdegree;
		}
	}

	// Construct initial pagerank (power iteration #1)
	vector<double> pageranks;
	pageranks.assign(n, 1.0 / n);

	// Matrix multiplication
	while (numPowIterations > 1) {
		matrixMult(adjMatrix, pageranks);
		numPowIterations--;
	}

	// Output pagerank vector after t power iterations
	cout << fixed << setprecision(2);
	for (unsigned int i = 0; i < nodes.size(); i++) {
		cout << nodes[i] << ": " << pageranks[i] << endl;
	}

	return 0;
}


void read(vector<edgePair>& edgeList, vector<string>& nodes, int& n, string fileName) {

	ifstream fileReader(fileName); // Open the file
	
	if (fileReader.is_open()) {
		string line = "";
		getline(fileReader, line);

		// Two tokens on first line
		stringstream s(line);
		string token = "";
		int numLines = 0;
		getline(s, token, ' ');

		try {
			numLines = stoi(token); // Parse string token to int type 
		}
		catch (invalid_argument& error) {
			numLines = 0;
			cout << "ERROR: Invalid Argument (Number of Lines)" << endl;
			cerr << error.what();
		}

		// Get next token (# power iterations)
		getline(s, token, ' ');

		try {
			n = stoi(token);
		}
		catch (invalid_argument& error) {
			n = 0;
			cout << "ERROR: Invalid Argument (Power Iterations)" << endl;
			cerr << error.what();
		}

		edgePair newEdge;
		set<string> uniques;
		for (int i = 0; i < numLines; i++) {
			
			getline(fileReader, line); // Read new line w/ every iteration
			stringstream siteReader(line);
			
			getline(siteReader, token, ' '); // Get origin node
			newEdge.first = token;
			uniques.insert(token);
			getline(siteReader, token, ' '); // Get destination node
			newEdge.second = token;
			uniques.insert(token);

			edgeList.push_back(newEdge);
		}

		// Convert set into vector (duplicates filtered out)
		vector<string> v(uniques.begin(), uniques.end());
		nodes = v;
	}

	else {
		cout << "ERROR: File not opened, no data read" << endl;
	}
}

// Calculate matrix product of a nxn matrix by a nx1 vector x_k+1 = A*x
void matrixMult(vector<vector<double>>& A, vector<double>& x) {

	// Verify dimensions are correct
	if (A[0].size != x.size) {
		cout << "ERROR: Dimension mismatch" << endl;
	}

	vector<double> output;
	output.assign(x.size(), 0.0f);

	for (unsigned int i = 0; i < x.size(); i++) {
		output[i] = dotProduct(A[i], x);
	}

	x = output;
}

// Calculates the dot product between x and y
double dotProduct(vector<double>& x, vector<double>& y) {

	// Verify that the dot product is defined
	if (x.size() != y.size()) {
		cout << "ERROR: Dimensions of parameters do not match, dot product undefined";
		return 0.0f;
	}

	double dotProd = 0.0f;
	for (unsigned int i = 0; i < x.size(); i++) {
		dotProd += x[i] * y[i];
	}

	return dotProd;
}
