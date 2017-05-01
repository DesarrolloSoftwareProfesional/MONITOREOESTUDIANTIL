function msg_success(msg) {
  base(msg, "#3eb839", "check-circle");
}

function msg_error(msg) {
  base(msg, "#dc6061", "times-circle");
}

function msg_warning(msg) {
  base(msg, "#f6ac2b", "exclamation-circle");
}

function msg_info(msg) {
  base(msg, "#03A9F4", "info-circle");
}

function base(msg, background, icon) {
  $.notify("&nbsp&nbsp" + msg, {
    align: "right",
    verticalAlign: "bottom",
    color: "#fff",
    background: background,
    icon: icon,
    close: true
  });
}
