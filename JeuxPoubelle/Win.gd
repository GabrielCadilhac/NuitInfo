extends Sprite



func _ready():
	pass 
func _process(delta):
	pass

func followMouse():
	position = get_global_mouse_position()

func _on_Area2D_input_event(viewport, event, shape_idx):
	if event is InputEventMouseButton:
		get_tree().change_scene("res://victoire.tscn")

