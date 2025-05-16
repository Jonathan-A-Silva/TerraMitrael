document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("cadastro");
    const mensagemDiv = document.getElementById("mensagem");
    const submitButton = form.querySelector("input[type='submit']");

    form.addEventListener("submit", (event) => {
        event.preventDefault();

        const nickname = form.nickname.value.trim();
        const password = form.password.value.trim();

        mensagemDiv.style.display = "none";
        mensagemDiv.textContent = "";

        submitButton.disabled = true;

        const pathArray = window.location.pathname.split('/');
        const contextPath = pathArray.length > 1 ? '/' + pathArray[1] : '';

        fetch(`${contextPath}/register-user`, {
            method: "POST",
            headers: {
                "Content-Type": "application/x-www-form-urlencoded"
            },
            body: new URLSearchParams({
                nickname,
                password
            })
        })
        .then(response => response.json())
        .then(data => {
            mensagemDiv.style.display = "block";
            mensagemDiv.textContent = data.mensagem;

            if (data.sucesso) {
                mensagemDiv.style.backgroundColor = "#2ecc71";
                setTimeout(() => {
                    mensagemDiv.style.display = "none";
                    window.location.href = document.referrer || contextPath;
                }, 3000);
            } else {
                mensagemDiv.style.backgroundColor = "#e74c3c";
                setTimeout(() => {
                    mensagemDiv.style.display = "none";
                }, 4000);
            }
        })
        .catch(error => {
            mensagemDiv.style.display = "block";
            mensagemDiv.style.backgroundColor = "#e74c3c";
            mensagemDiv.textContent = "Erro de comunicação com o servidor";

            setTimeout(() => {
                mensagemDiv.style.display = "none";
            }, 4000);
        })
        .finally(() => {
            submitButton.disabled = false;
        });
    });
});
