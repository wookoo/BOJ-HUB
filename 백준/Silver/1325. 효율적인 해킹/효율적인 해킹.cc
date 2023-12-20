#include <iostream>
#include <vector>
#include <queue>

using namespace std;

vector<vector<int>> graph;
vector<bool> visited;
vector<int> result;

void getMaxPen(int x) {
    queue<int> q;

    q.push(x);
    visited[x] = true;

    while (!q.empty()) {
        int front = q.front();
        q.pop();
        for (int value : graph[front]) {
            if (!visited[value]) {
                visited[value] = true;
                q.push(value);
                result[value]++;
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    graph.resize(n + 1);
    visited.resize(n + 1, false);
    result.resize(n + 1, 0);

    for (int i = 0; i < m; i++) {
        int from, to;
        cin >> from >> to;
        graph[from].push_back(to);
    }

    for (int i = 1; i <= n; i++) {
        fill(visited.begin(), visited.end(), false);
        getMaxPen(i);
    }

    int max = 0;
    for (int i = 1; i <= n; i++) {
        if (result[i] > max) {
            max = result[i];
        }
    }

    for (int i = 1; i <= n; i++) {
        if (result[i] == max) {
            cout << i << " ";
        }
    }

    return 0;
}
