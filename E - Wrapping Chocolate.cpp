#include <bits/stdc++.h>
using namespace std;

int main() {
    int N, M;
    cin >> N >> M;

    vector<long long> lench(N + 1), wech(N + 1);
    vector<long long> lenbo(M + 1), webo(M + 1);

    vector<pair<long long, int>> len;

    for (int i = 1; i <= N; i++) {
        cin >> lench[i];
        len.push_back({lench[i], -i});
    }

    for (int i = 1; i <= N; i++) {
        cin >> wech[i];
    }

    for (int i = 1; i <= M; i++) {
        cin >> lenbo[i];
        len.push_back({lenbo[i], i});
    }

    for (int i = 1; i <= M; i++) {
        cin >> webo[i];
    }

    sort(len.begin(), len.end(), greater<pair<long long, int>>());

    multiset<long long> st;

    for (auto p : len) {
        long long l = p.first;
        int idx = p.second;

        if (idx > 0) {
            st.insert(webo[idx]);
        } else {
            idx = -idx;

            auto it = st.lower_bound(wech[idx]);

            if (it == st.end()) {
                cout << "No\n";
                return 0;
            }

            st.erase(it);
        }
    }

    cout << "Yes\n";

    return 0;
}