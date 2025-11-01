# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
- mkdir esMerge; cd esMerge
- git clone git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git

2. Ci si assicuri di avere localmente entrambi i branch remoti
- avendo fatto `git clone` il branch di default master è già stato salvato localmente
- git checkout -b feature origin/feature
- git --no-pager branch -a
- git status:
   On branch feature
   Your branch is up to date with 'origin/feature'.
   nothing to commit (use -u to show untracked files)

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master` e da qui si esegua il merge di `feature`
- git checkout master
- git merge feature:
   Auto-merging HelloWorld.java
   CONFLICT (content): Merge conflict in HelloWorld.java
   Automatic merge failed; fix conflicts and then commit the result.

4. Si noti che viene generato un **merge conflict**!
- git status:
   On branch master
   Your branch is up to date with 'origin/master'.
   You have unmerged paths.
  (fix conflicts and run "git commit")
  (use "git merge --abort" to abort the merge)
   Unmerged paths:
  (use "git add <file>..." to mark resolution)
        both modified:   HelloWorld.java
   no changes added to commit (use "git add" and/or "git commit -a")
- git merge --abort

5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
- git checkout feature; nvim HelloWorld.java ( prendo la parte del programma da feature )
- git checkout master ( modifico HelloWorld.java di master )
- git add HelloWorld.java; git commit -m "Modifying master's HelloWorld.java"
- git checkout feature ( faccio lo stesso in feature )
- git checkout master; git merge feature

6. Si crei un nuovo repository nel proprio github personale
- git@github.com:Svegog/lab6_61_point6_7_8_9.git

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
- git remote remove origin
- git remote add origin git@github.com:Svegog/lab6_61_point6_7_8_9.git

8. Si faccia push del branch `master` sul proprio repository
- git push -u origin master

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
- git branch --set-upstream-to=origin/master

