export default async function Autenticate(UserEmail, UserPassword){

    const user = {
        email: UserEmail,
        password: UserPassword
    };

    const response = await fetch('http://10.72.2.112:8080/user/login/', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    });
    return response.status == 200;
}