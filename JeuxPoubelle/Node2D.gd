extends Node2D

var images_path = []
var score = 0


var nouvim = load("closedhand_100189-1.png")
var imbaz = load("main ouverte.jpg")
var leftclickpress = false
# Declare member variables here. Examples:
# var a = 2
# var b = "text"



func random_image():
	
	""" Cette fonction permet de récupérer le chemin d'une image dans le projet aléatoirement. (Prototype) """
	
	var rng = RandomNumberGenerator.new()
	
	images_path.append("bouteille.png")
	images_path.append("banane.png")
	images_path.append("journal.png")
	images_path.append("carton.png")
	
	
	rng.randomize()
	var my_random_number = rng.randf_range(0, images_path.size())
	
	return images_path[my_random_number]


func load_images():
	
	var image = Image.new()
	var image2 = Image.new()
	var image3 = Image.new()
	var image4 = Image.new()
	var image5 = Image.new()
	
	
	image.load(random_image())
	image2.load(random_image())
	image3.load(random_image())
	image4.load(random_image())
	image5.load(random_image())
	
	var texture = ImageTexture.new()
	texture.create_from_image(image,0)
	$Icon.texture = texture;
	
	var texture2 = ImageTexture.new()
	texture2.create_from_image(image2,0)
	$Sprite.texture = texture2;
	
	
	var texture3 = ImageTexture.new()
	texture3.create_from_image(image3,0)
	$Sprite2.texture = texture3;
	
	var texture4 = ImageTexture.new()
	texture4.create_from_image(image4,0)
	$Sprite3.texture = texture4;
	
	var texture5 = ImageTexture.new()
	texture5.create_from_image(image5,0)
	$Sprite4.texture = texture5;

var pos = null
var pos1 = null
var pos2 = null
var pos3 = null
var pos4 =null

func _ready():
	
	load_images()
	
	pos = $Icon.position
	pos1 = $Sprite.position
	pos2 = $Sprite2.position
	pos3 = $Sprite3.position
	pos4 = $Sprite4.position
	
	

func verifie():
	if poubelle1 and poubelle2 and poubelle3 and poubelle4 and poubelle5:
		get_tree().change_scene("res://victoire.tscn")
	
var selectedFirstItem= false
var selectedItem2 =false
var selectedItem3 =false
var selectedItem4 =false
var selectedItem5 =false

var collisionItem1 = false
var collisionItem2 = false
var collisionItem3 = false
var collisionItem4 = false
var collisionItem5 = false

var poubelle1 = false
var poubelle2 = false
var poubelle3 = false
var poubelle4 = false
var poubelle5 = false
#wow josian possède vraiment une énorme queue c'est un truc de malade comment elle est grosse.
#Demande à momo il te diras la même chose  



func _on_Area2D_input_event(viewport, event, shape_idx):
	
	

	if Input.is_action_just_pressed("click") : 
		selectedFirstItem = true
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)
		
func _on_Area2D_input_event2(viewport, event, shape_idx):
	if Input.is_action_just_pressed("click") : 
		selectedItem2 = true
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)
		
func _on_Area2D_input_event3(viewport, event, shape_idx):
	if Input.is_action_just_pressed("click") : 
		selectedItem3 = true
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)

func _on_Area2D_input_event4(viewport, event, shape_idx):
	if Input.is_action_just_pressed("click") : 
		
		selectedItem4 = true
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)


func _on_Area2D_input_event5(viewport, event, shape_idx):
	if Input.is_action_just_pressed("click") : 
		selectedItem5 = true
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)
		
func _physics_process(delta):
	if selectedFirstItem:
		$Icon.position = lerp($Icon.position, get_global_mouse_position(),25 * delta)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)
	
	if selectedItem2:
		$Sprite.position = lerp($Sprite.position, get_global_mouse_position(),25 * delta)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)
		
	if selectedItem3:
		$Sprite2.position = lerp($Sprite2.position, get_global_mouse_position(),25 * delta)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)
		
		
	if selectedItem4:
		$Sprite3.position = lerp($Sprite3.position, get_global_mouse_position(),25 * delta)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)
	
	if selectedItem5:
		$Sprite4.position = lerp($Sprite4.position, get_global_mouse_position(),25 * delta)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)	
	

func _input(event):
	
	
	if Input.is_action_pressed("click"):
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)
		
		
	if event is InputEventMouseButton:
		
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
		Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)
		if event.button_index == BUTTON_LEFT and not event.pressed:
			if(selectedFirstItem == true):
				if(collisionItem1):
					$Icon.position = pos
					collisionItem1 = false
					
				if (!poubelle1):
					$Icon.position = pos
					collisionItem1 = false
					score -= 1
				else:
					score += 1
				selectedFirstItem = false
				
				
			if(selectedItem2 == true ):
				if(collisionItem2):
					$Sprite.position = pos1
					collisionItem2 = false
					
				if (!poubelle2):
					$Sprite.position = pos1
					collisionItem2 = false
					score -= 1
				else:
					score += 1
				selectedItem2 = false
				
			if(selectedItem3 == true):
				if(collisionItem3):
					$Sprite2.position = pos2
					collisionItem3 = false
					
				if (!poubelle3):
					$Sprite2.position = pos2
					collisionItem3 = false
					score -= 1
				else:
					score += 1
				selectedItem3 = false
				
			if(selectedItem4 == true):
				if(collisionItem4):
					$Sprite3.position = pos3
					collisionItem4 = false
					
				if (!poubelle4):
					$Sprite3.position = pos3
					collisionItem4 = false
					score -= 1
				else:
					score+=1
				selectedItem4 = false
				
			if(selectedItem5 == true):
				if(collisionItem5):
					$Sprite4.position = pos4
					collisionItem5 = false
					
				if (!poubelle5):
					$Sprite4.position = pos4
					collisionItem5 = false 
					score -= 1
				else:
					score+=1
				selectedItem5 = false
			verifie()
		elif event.button_index == BUTTON_LEFT and event.pressed:
			 Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_DRAG)
			 Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_MOVE)
			 Input.set_custom_mouse_cursor(nouvim, Input.CURSOR_CAN_DROP)
			
# Called every frame. 'delta' is the elapsed time since the previous frame.
#func _process(delta):
#	pass
func _on_Area2D_area_entered(area):
	if (area == $Sprite4/Area2D and selectedItem5):
		collisionItem5 = true
	if (area == $Sprite3/Area2D and selectedItem4):
		collisionItem4 = true
	if (area == $Sprite2/Area2D and selectedItem3):
		collisionItem3 = true
	if (area == $Sprite/Area2D and selectedItem2):
		collisionItem2 = true
	if (area == $Icon/Area2D and selectedFirstItem):
		collisionItem1 = true
	
	
		
func _on_Area2D_area_exited(area):
	if (area == $Sprite4/Area2D and selectedItem5):
		collisionItem5 = false
	if (area == $Sprite3/Area2D and selectedItem4):
		collisionItem4 = false
	if (area == $Sprite2/Area2D and selectedItem3):
		collisionItem3 = false
	if (area == $Sprite/Area2D and selectedItem2):
		collisionItem2 = false
	if (area == $Icon/Area2D and selectedFirstItem):
		collisionItem1 = false
		
		
func _on_POUBELLE_area_entered(area):
	if (area == $Sprite4/Area2D and selectedItem5):

		poubelle5 = true
	if (area == $Sprite3/Area2D and selectedItem4):
		poubelle4 = true

	if (area == $Sprite2/Area2D and selectedItem3):
		poubelle3 = true

	if (area == $Sprite/Area2D and selectedItem2):
		poubelle2 = true

	if (area == $Icon/Area2D and selectedFirstItem):
		poubelle1 = true
		
	

func _on_POUBELLE_area_exited(area):
	if (area == $Sprite4/Area2D and selectedItem5):
		poubelle5 = false
		

	if (area == $Sprite3/Area2D and selectedItem4):
		poubelle4 = false

	if (area == $Sprite2/Area2D and selectedItem3):
		poubelle3 = false

	if (area == $Sprite/Area2D and selectedItem2):
		poubelle2 = false

	if (area == $Icon/Area2D and selectedFirstItem):
		poubelle1 = false











