class Solution:
    def findLadders(self, beginWord, endWord, wordList):
        words = set(wordList)
        if endWord not in words:
            return []
        parents = defaultdict(list)
        level = {beginWord}
        found = False
        while level and not found:
            words -= level
            next_level = set()
            for word in level:
                word_arr = list(word)
                for i in range(len(word)):
                    old = word_arr[i]
                    for c in "abcdefghijklmnopqrstuvwxyz":
                        word_arr[i] = c
                        new_word = "".join(word_arr)
                        if new_word in words:
                            parents[new_word].append(word)
                            next_level.add(new_word)
                            if new_word == endWord:
                                found = True
                    word_arr[i] = old
            level = next_level
        if not found:
            return []
        ans = []
        def dfs(word, path):
            if word == beginWord:
                ans.append(path[::-1])
                return
            for p in parents[word]:
                dfs(p, path + [p])
        dfs(endWord, [endWord])
        return ans