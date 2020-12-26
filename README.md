# Every
掲示板アプリEvery  
毎日気軽に使ってほしいとの思いから名付けました。

現在の機能  
ログイン、ログアウト  
メッセージ投稿  
メッセージ削除 


今後追加したい機能  
いいね機能  
メッセージ編集  
日付の入力  
簡単ログイン(名前を入力すればログインできる)  
権限の追加(スーパーユーザー)  
掲示板の拡張(Topic)を選択できる  
コーディング



★Dockerの起動方法
dockerの立ち上げ
Borad/上で下記コマンドをたたく

// docker環境ビルド
docker-compose build

// dockerをバックグラウンドで起動
docker-compose up -d

// javaコンテナにインスペクション
docker-compose exec java bash

// mavenビルド
root@62acca270468:/srv# sh mvnw package

// アプリケーション実行
root@62acca270468:/srv# java -jar target/Borad-0.0.1-SNAPSHOT.jar
