使用 docker 启动 redis

```sh
docker run -d -p 6379:6379 redis
```

安装依赖

```sh
pip install -r requirements.txt
```

启动 celery 服务

```sh
celery -A tasks worker --loglevel=info -P eventlet
```

执行调用脚本

```sh
python test.py
```

应该输出 8
