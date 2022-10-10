class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<int> dist(n + 1, INT_MAX);
        dist[k] = 0;
        for (int i = 1; i <= n; i++) {
            for (auto& t : times) {
                if (dist[t[0]] != INT_MAX && dist[t[1]] > dist[t[0]] + t[2]) {
                    dist[t[1]] = dist[t[0]] + t[2];
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = max(res, dist[i]);
        }
        return res == INT_MAX ? -1 : res;
    }
};