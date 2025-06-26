document.addEventListener("DOMContentLoaded", () => {
    let editMode = false;
    const editButton = document.getElementById("edit-button");
    const mensagemDiv = document.getElementById("mensagem");
    const nicknameP = document.getElementById("p-ninkname");
    const nicknameInput = document.getElementById("input-ninkname");
    const imageInput = document.getElementById("image");
    const pathArray = window.location.pathname.split('/');
    const contextPath = pathArray.length > 1 ? '/' + pathArray[1] : '';

    if (!editButton || !nicknameInput || !imageInput) return;

    const updateUI = () => {
        editButton.value = editMode ? "Save" : "Edit";
        nicknameP.style.display = editMode ? "none" : "flex";
        nicknameInput.style.display = editMode ? "flex" : "none";
        imageInput.style.visibility = editMode ? "visible" : "hidden";
    };

    const sendProfile = () => {
        if (editMode) {
            const formData = new FormData(document.getElementById("profile-form"));
            fetch(`${contextPath}/edit-profile`, {
                method: "POST",
                body: formData
            })
                .then(response => response.json())
                .then(data => {
                    if (data.sucesso) {
                        window.location.reload();
                    } else {
                        mensagemDiv.style.display = "block";
                        mensagemDiv.style.backgroundColor = "#e74c3c";
                        window.location.reload();
                    }

                    setTimeout(() => {
                        mensagemDiv.style.display = "none";
                    }, 5000);
                })
                .catch(error => {
                    mensagemDiv.style.display = "block";
                    mensagemDiv.style.backgroundColor = "#e74c3c";
                    mensagemDiv.textContent = "Erro de comunicação com o servidor";

                    setTimeout(() => {
                        mensagemDiv.style.display = "none";
                    }, 5000);
                });
        }
    };

    editButton.addEventListener("click", () => {
        sendProfile();
        editMode = !editMode;
        updateUI();
    });

});