db.createUser({
    user: 'ababacar',
    pwd: 'ababacarTEST2022',
    roles: [
        {
            role: 'readWrite',
            db: 'mongo-kiwip-db'
        }
    ]
})