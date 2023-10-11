#include <iostream>
#include <string>
#include <vector>
#include <cstdlib>
#include <ctime>

const std::string TARGET_PHRASE = "You get it!";
const int POP_SIZE = 300;
const double CROSS_RATE = 0.4;
const double MUTATION_RATE = 0.01;
const int N_GENERATIONS = 1000;

const int DNA_SIZE = TARGET_PHRASE.length();
const std::vector<char> TARGET_DNA(TARGET_PHRASE.begin(), TARGET_PHRASE.end());
const std::pair<int, int> ASCII_BOUND = std::make_pair(32, 127);

class GA {
public:
    GA(int DNA_size, const std::pair<int, int>& DNA_bound, double cross_rate, double mutation_rate, int pop_size)
        : DNA_size(DNA_size), DNA_bound(DNA_bound), cross_rate(cross_rate), mutation_rate(mutation_rate), pop_size(pop_size) {
        DNA_bound.second += 1;
        pop.resize(pop_size, std::vector<char>(DNA_size));
        initializePopulation();
    }

    std::string translateDNA(const std::vector<char>& DNA) {
        return std::string(DNA.begin(), DNA.end());
    }

    std::vector<int> getFitness() {
        std::vector<int> fitness(pop_size, 0);
        for (int i = 0; i < pop_size; ++i) {
            for (int j = 0; j < DNA_size; ++j) {
                if (pop[i][j] == TARGET_DNA[j]) {
                    fitness[i]++;
                }
            }
        }
        return fitness;
    }

    void select() {
        std::vector<int> fitness = getFitness();
        double totalFitness = 0.0;
        for (int i = 0; i < pop_size; ++i) {
            totalFitness += fitness[i];
        }
        std::vector<std::vector<char>> newPop(pop_size, std::vector<char>(DNA_size));
        for (int i = 0; i < pop_size; ++i) {
            double randNum = static_cast<double>(rand()) / RAND_MAX * totalFitness;
            int idx = 0;
            while (randNum > 0) {
                randNum -= fitness[idx];
                idx++;
            }
            idx--;
            newPop[i] = pop[idx];
        }
        pop = newPop;
    }

    void crossover(std::vector<char>& parent, const std::vector<char>& partner) {
        if (static_cast<double>(rand()) / RAND_MAX < cross_rate) {
            int i = static_cast<int>(static_cast<double>(rand()) / RAND_MAX * DNA_size);
            for (int j = i; j < DNA_size; ++j) {
                parent[j] = partner[j];
            }
        }
    }

    void mutate(std::vector<char>& child) {
        for (int i = 0; i < DNA_size; ++i) {
            if (static_cast<double>(rand()) / RAND_MAX < mutation_rate) {
                child[i] = static_cast<char>(static_cast<int>(static_cast<double>(rand()) / RAND_MAX * (DNA_bound.second - DNA_bound.first)) + DNA_bound.first);
            }
        }
    }

    void evolve() {
        select();
        std::vector<std::vector<char>> newPop(pop_size, std::vector<char>(DNA_size));
        for (int i = 0; i < pop_size; ++i) {
            int partnerIdx = static_cast<int>(static_cast<double>(rand()) / RAND_MAX * pop_size);
            crossover(newPop[i], pop[i], pop[partnerIdx]);
            mutate(newPop[i]);
        }
        pop = newPop;
    }

private:
    int DNA_size;
    std::pair<int, int> DNA_bound;
    double cross_rate;
    double mutation_rate;
    int pop_size;
    std::vector<std::vector<char>> pop;

    void initializePopulation() {
        for (int i = 0; i < pop_size; ++i) {
            for (int j = 0; j < DNA_size; ++j) {
                pop[i][j] = static_cast<char>(static_cast<int>(static_cast<double>(rand()) / RAND_MAX * (DNA_bound.second - DNA_bound.first)) + DNA_bound.first);
            }
        }
    }
};

int main() {
    std::srand(static_cast<unsigned>(std::time(0)));
    GA ga(DNA_SIZE, ASCII_BOUND, CROSS_RATE, MUTATION_RATE, POP_SIZE);

    for (int generation = 0; generation < N_GENERATIONS; ++generation) {
        std::vector<int> fitness = ga.getFitness();
        int maxFitnessIdx = 0;
        for (int i = 0; i < POP_SIZE; ++i) {
            if (fitness[i] > fitness[maxFitnessIdx]) {
                maxFitnessIdx = i;
            }
        }
        std::vector<char> bestDNA = ga.pop[maxFitnessIdx];
        std::string bestPhrase = ga.translateDNA(bestDNA);
        std::cout << "Gen " << generation << ": " << bestPhrase << std::endl;
        if (bestPhrase == TARGET_PHRASE) {
            break;
        }
        ga.evolve();
    }

    return 0;
}
