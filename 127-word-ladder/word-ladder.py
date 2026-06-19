class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        words = set(wordList)
        words.discard(beginWord)
        q = deque()
        q.append((beginWord, 1))
        while q:
            word, steps = q.popleft()
            if word == endWord:
                return steps
            for i in range(len(word)):
                for c in range(ord('a'), ord('z') + 1):
                    new_word = word[:i] + chr(c) + word[i+1:]
                    if new_word in words:
                        words.discard(new_word)
                        q.append((new_word, steps+1))
        return 0