def main():
    processes = int(input("Number of processes: "))
    resources = int(input("Number of resources: "))
    max_resources = [int(i) for i in input("Maximum resources: ").split()]

    print("\n-- Allocated resources for each process --")
    currently_allocated = [[int(i) for i in input(f"Process {j + 1}: ").split()] for j in range(processes)]

    print("\n-- Maximum resources for each process --")
    max_need = [[int(i) for i in input(f"Process {j + 1}: ").split()] for j in range(processes)]

    allocated = [0] * resources
    for i in range(processes):
        for j in range(resources):
            allocated[j] += currently_allocated[i][j]
    print(f"\nTotal allocated resources: {allocated}")

    available = [max_resources[i] - allocated[i] for i in range(resources)]
    print(f"Total available resources: {available}\n")

    running = [True] * processes
    count = processes

    while count != 0:
        safe = False
        for i in range(processes):
            if running[i]:
                executing = True
                for j in range(resources):
                    if max_need[i][j] - currently_allocated[i][j] > available[j]:
                        executing = False
                        break
                if executing:
                    print(f"Process {i + 1} is executing")
                    running[i] = False
                    count -= 1
                    safe = True
                    for j in range(resources):
                        available[j] += currently_allocated[i][j]
                    break
        if not safe:
            print("The processes are in an unsafe state.")
            break
    print(f"The process is in a safe state.\nAvailable resources: {available}")

if __name__ == '__main__':
    main()
