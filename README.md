<h1>Feign 예시</h1>
<hr>

[GET]
http://localhost:8080/example/call-feign-get-item
=> http://localhost:8080/example/get-item 호출<BR>
<BR>
response
```aidl
[
    {
        "itemId": "0001",
        "itemName": "장난감",
        "price": 1000
    },
    {
        "itemId": "0002",
        "itemName": "우유",
        "price": 2300
    },
    {
        "itemId": "0003",
        "itemName": "책",
        "price": 21000
    }
]
```

[POST]
http://localhost:8080/example/call-feign-set-item
=> http://localhost:8080/example/set-item 호출<BR>
itemName에 우유가 포함되어 있는 리스트를 반환
<BR>

request
```aidl
[
    {
        "itemId": "0001",
        "itemName": "장난감",
        "price": 1000
    },
    {
        "itemId": "0002",
        "itemName": "우유",
        "price": 2300
    },
     {
        "itemId": "0002",
        "itemName": "우유2",
        "price": 2300
    },
    {
        "itemId": "0003",
        "itemName": "책",
        "price": 21000
    }
]
```


response
```aidl
{
    "error": null,
    "data": [
        {
            "itemId": "0002",
            "itemName": "우유",
            "price": 2300
        },
        {
            "itemId": "0002",
            "itemName": "우유2",
            "price": 2300
        }
    ]
}
```

