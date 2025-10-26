
# COM6115: Text Processing
# Regular Expressions Lab Class

import sys, re

#------------------------------

testRE = re.compile('(logic|sicstus)', re.I)  #practice 1
tagRE = re.compile(r"<(/?)([^>]*)>") #practice 2
paramRE = re.compile(r'([\w-]+=(?:"[^"]*"|\S+))') #practice 3
pairRE = re.compile(r"<([a-zA-Z0-9]+)[^>]*>(.*?)</\1>") #practice 4
urlRE = re.compile(r'<a\s+[^>]*href=([^\s>]+)')  #practice 5
stripRE = re.compile(r"<[^>]*>") # practice 6

#------------------------------

with open('RGX_DATA.html') as infs: 
    linenum = 0
    for line in infs:
        linenum += 1
        if line.strip() == '':
            continue
        print('  ', '-' * 100, '[%d]' % linenum, '\n   TEXT:', line, end='')

# 練習一：找出 logic 或 sicstus
#        m = testRE.search(line)
#        if m:
#            print('** TEST-RE:', m.group(1))

        # This uses the finditer method, which returns an iterator for all matches found.
        mm = testRE.finditer(line)
        for m in mm:
            print('** TEST-RE:', m.group(1))

# 練習二：找出 HTML 標籤
#         mm_tag= tagRE.finditer(line)
#         for m in mm_tag:
#             print('** TAG-RE:', m.group(1))
#              # 在 Regex 中：m.group(0) 或 m.group() 代表「匹配到的整個字串」 。
#              # m.group(1) 代表「匹配到的第 1 個括號 ( ) 裡的內容」 。

# 練習三：找出 HTML 標籤及其參數
        mm_tag = tagRE.finditer(line)
        for m in mm_tag:
            # m.group(1) 是抓斜線 '/'
            #  # m.group(2) 是抓標籤內容 (p, table border=1, ...)
            if m.group(1): 
                print(f"** CLOSETAG: {m.group(2)}")
            else:
                # 1. 用空白鍵把標籤名稱和參數字串拆開
                parts = m.group(2).split(None, 1)
                tag_name = parts[0] # 標籤名稱

                print(f"** OPENTAG: {tag_name}") # 先印出 OPENTAG

                # 2. 檢查 parts 陣列長度，如果 > 1，表示有參數
                if len(parts) > 1:
                    param_string = parts[1]
        
                    # 3. 用 paramRE 找出所有參數
                    param_matches = paramRE.finditer(param_string)
                    for pm in param_matches:
                        # pm.group(1) 就是 ([\w-]+=(?:"[^"]*"|\S+)) 抓到的內容
                        print(f"   ** PARAM: {pm.group(1)}") 
    
# 練習四
        mm_pair = pairRE.finditer(line)
        for m in mm_pair:
            print(f"** PAIR [{m.group(1)}]: {m.group(2)}")

# 練習五
        mm_url = urlRE.finditer(line)
        for m in mm_url:
            print(f"** URL: {m.group(1)}")
# 練習六
        # 使用 .sub()，將所有"stripRE" 匹配到的標籤，替換成''(空字串)
        stripped_line = stripRE.sub('', line)
        #移出前後多餘的空白和換行
        stripped_line_clean = stripped_line.strip()
        # 只印出有內容的行
        if stripped_line_clean:
            print(f"** STRIPPED: {stripped_line_clean}")


