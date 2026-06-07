# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional[TreeNode]:
        mp = {}
        root = {}
        for p, c, l in descriptions:
            if p not in mp:
                mp[p] = TreeNode(p)
            if c not in mp:
                mp[c] = TreeNode(c)
            if l == 1:
                mp[p].left = mp[c]
            else:
                mp[p].right = mp[c]
            if root.get(p, 0) != -1:
                root[p] = 1
            root[c] = -1
        root_val = 0
        for node, state in root.items():
            if state == 1:
                root_val = node
                break
        return mp[root_val]