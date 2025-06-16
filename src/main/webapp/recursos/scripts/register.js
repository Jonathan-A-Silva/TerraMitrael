document.addEventListener("DOMContentLoaded", () => {
    let isSubmitting = false;
    const form = document.getElementById("cadastro");
    const mensagemDiv = document.getElementById("mensagem");
    const pathArray = window.location.pathname.split('/');
    const contextPath = pathArray.length > 1 ? '/' + pathArray[1] : '';

    form.addEventListener("submit", (event) => {
        event.preventDefault();
        const formData = new FormData(form);

        if (!isSubmitting) {
            isSubmitting = true
            fetch(`${contextPath}/register-user`, {
                method: "POST",
                body: formData
            })
                .then(response => response.json())
                .then(data => {

                    if (data.sucesso) {
                        window.location.href = document.referrer || contextPath;
                    } else {
                        mensagemDiv.style.display = "block";
                        mensagemDiv.style.backgroundColor = "#e74c3c";
                        mensagemDiv.textContent = data.mensagem;
                        setTimeout(() => {
                            mensagemDiv.style.display = "none";
                        }, 5000);
                    }
                })
                .catch(error => {
                    mensagemDiv.style.display = "block";
                    mensagemDiv.style.backgroundColor = "#e74c3c";
                    mensagemDiv.textContent = "Erro de comunicação com o servidor";

                    setTimeout(() => {
                        mensagemDiv.style.display = "none";
                    }, 5000);
                })
                .finally(() => {
                    isSubmitting = false;
                });
        }
    });
});
