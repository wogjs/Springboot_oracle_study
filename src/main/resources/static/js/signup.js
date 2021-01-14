var main = {
    init : function() {
        var _this = this;

        $('#btn-signup').on('click', function () {
            _this.signup();
        });
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },

    signup : function () {
        var data = {
            ID: $('#ID').val(),
            PW: $('#PW').val(),
            NAME: $('#NAME').val(),
            EMAIL: $('#EMAIL').val(),
            PHONE: $('#PHONE').val()
        };

        if(data.ID == "" || data.PW == "" || data.NAME == "" || data.EMAIL == "" || data.PHONE == "") {
            alert('모든 항목을 작성해주세요')
            return null;
        }

        $.ajax({
            type: 'POST',
            url: '/users/signup',
            dataType: 'JSON',
            contentType: 'applocation/json; charset=UTF-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('회원가입 되었습니다.');
            window.location.href = '/users/login';
        }).fail(function () {
            if(data.id != "") {
                alert('이미 사용중인 아이디입니다.');
            }
        });
    },
}

main.init();